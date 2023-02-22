SECTION = "libs"

# libxcrypt for -lcrypt
DEPENDS = "openssl libssh libyang cmocka libxcrypt"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "git://git.codelinaro.org/clo/le/libnetconf2/;branch=caf/master"
SRCREV = "0722eb1f43e84eb9152ac0d5fbcfab6293fce573"

SRC_URI += "file://0001-mplane-changes.patch"

S = "${WORKDIR}/git"

inherit cmake

do_install_append(){
        install -d ${D}/usr/share/cmake/Modules/
        install -m 0644 ${S}/FindLibNETCONF2.cmake ${D}/usr/share/cmake/Modules/FindLibNETCONF2.cmake
}

EXTRA_OECMAKE += " \
	-DCMAKE_BUILD_TYPE=RELEASE \
"

FILES_${PN} += " \
    /usr/share/cmake/Modules/FindLibNETCONF2.cmake \
"
