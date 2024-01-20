SUMMARY = "All OSS binaries/files needded by ru mplane"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
    netopeer2 \
    yang-modules \
"

