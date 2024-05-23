SECTION = "libs"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}:"

SRC_URI  = "file://vendor/qcom/proprietary/mplane/common/yang/modules/v12/ietf/"
SRC_URI += "file://vendor/qcom/proprietary/mplane/common/yang/modules/v12/oran/"

SI = "${WORKDIR}/vendor/qcom/proprietary/mplane/common/yang/modules/v12/ietf"
SO = "${WORKDIR}/vendor/qcom/proprietary/mplane/common/yang/modules/v12/oran"

do_install(){
    install -d ${D}${datadir}/yang/ru/modules/oran/v12
    install -m 0555 ${SI}/*.yang ${D}${datadir}/yang/ru/modules/oran/v12
    install -m 0555 ${SO}/*.yang ${D}${datadir}/yang/ru/modules/oran/v12
}

FILES_${PN} += " \
    ${datadir}/yang/ru/modules/oran/v12 \
"
