SECTION = "libs"

DEPENDS = "libssh libyang cmocka sysrepo libnetconf2 curl diag"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "git://git.codelinaro.org/clo/le/netopeer2.git;branch=caf4/libyang1"
SRCREV = "c596ed5635ca0013b62785c1733e61818b5ebfc6"

SRC_URI += "file://0001-mplane-changes.patch"
SRC_URI += "file://netopeer2.service"

S = "${WORKDIR}/git"

inherit cmake systemd

EXTRA_OECMAKE += " \
	-DCMAKE_BUILD_TYPE=RELEASE \
        -DLIBNETCONF2_ENABLED_SSH=TRUE \
        -DLIBNETCONF2_ENABLED_TLS=TRUE \
        -DBUILD_CLI=TRUE \
        -DGENERATE_HOSTKEY=FALSE \
        -DMERGE_LISTEN_CONFIG=FALSE \
        -DINSTALL_MODULES=FALSE \
"

FILES_${PN} += " \
	${datadir}/yang \
	${datadir}/mplane/setup.sh \
	${systemd_unitdir}/system/netopeer2.service \
"

do_install_append(){
  install -d ${D}${datadir}/mplane/
  install -m 0755 ${S}/scripts/setup.sh -D ${D}${datadir}/mplane/setup.sh
  install -d ${D}${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/netopeer2.service -D ${D}${systemd_unitdir}/system/netopeer2.service
}

SYSTEMD_SERVICE_${PN} = "netopeer2.service"