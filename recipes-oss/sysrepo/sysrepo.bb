SECTION = "libs"

DEPENDS = "cmocka libyang"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "git://git.codelinaro.org/clo/le/sysrepo/;branch=caf5/libyang1"
SRCREV = "458634640501ae272692ad5ceb8085d33f38ae91"

SRC_URI += "file://0001-mplane-changes.patch"

S = "${WORKDIR}/git"

inherit cmake useradd

EXTRA_OECMAKE += " \
        -DCMAKE_BUILD_TYPE=RELEASE \
    -DGEN_LANGUAGE_BINDINGS=TRUE \
    -DGEN_PYTHON_BINDINGS=FALSE \
    -DREPO_PATH=/data/mplane/sysrepo/ \
"

do_install_append(){
  install -m 755 -o radio -g radio -d ${D}/data/mplane/
}

FILES_${PN} += " \
        /data/mplane \
"