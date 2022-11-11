SECTION = "libs"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://git.codelinaro.org/clo/le/cmocka/;branch=caf2/master"
SRCREV = "f5e2cd77c88d9f792562888d2b70c5a396bfbf7a"
S = "${WORKDIR}/git"

inherit cmake
