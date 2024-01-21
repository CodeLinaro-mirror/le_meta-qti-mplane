SECTION = "libs"


LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

FILESPATH =+ "${WORKSPACE}:"

do_fetch() {
# O-ran v12
    wget -O v12.zip https://orandownloadsweb.azurewebsites.net/download?id=455
# Other modules or previous version
    wget -O notifications@2008-07-14.yang https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/notifications@2008-07-14.yang
    wget -O ietf-yang-metadata@2016-08-05.yang  https://www.netconfcentral.org/src/ietf-yang-metadata@2016-08-05.yang
    wget -O ietf-origin@2018-02-14.yang  https://www.netconfcentral.org/src/ietf-origin@2018-02-14.yang
    wget -O ietf-ssh-common@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-ssh-common%402019-07-02.yang
    wget -O ietf-crypto-types@2019-04-29.yang  https://www.ietf.org/ietf-ftp/yang/catalogmod/ietf-crypto-types@2019-04-29.yang
    wget -O ietf-tls-common@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-tls-common%402019-07-02.yang
    wget -O ietf-truststore@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-truststore%402019-07-02.yang
    wget -O ietf-netconf@2013-09-29.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-netconf%402013-09-29.yang
    wget -O ietf-netconf-with-defaults@2011-06-01.yang  https://www.netconfcentral.org/src/ietf-netconf-with-defaults@2011-06-01.yang
    wget -O ietf-netconf-nmda@2019-01-07.yang  https://www.netconfcentral.org/src/ietf-netconf-nmda@2019-01-07.yang
    wget -O ietf-tcp-common@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-tcp-common%402019-07-02.yang
    wget -O ietf-tcp-server@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-tcp-server%402019-07-02.yang
    wget -O ietf-tcp-client@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-tcp-client%402019-07-02.yang
    wget -O ietf-keystore@2019-04-29.yang  https://www.ietf.org/ietf-ftp/yang/catalogmod/ietf-keystore%402019-04-29.yang
    wget -O ietf-ssh-server@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-ssh-server%402019-07-02.yang
    wget -O ietf-tls-server@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-tls-server%402019-07-02.yang
    wget -O ietf-netconf-server@2019-07-02.yang  https://raw.githubusercontent.com/CESNET/netopeer2/ef8aff64a8d85be2b257501670f97580c1401b8d/modules/ietf-netconf-server%402019-07-02.yang
}
do_fetch[depends] += "unzip-native:do_populate_sysroot"

do_unpack(){
# Unzip without any subdirectory
    unzip -j -q -o ${DL_DIR}/v12.zip -d ${S}/oran
}

do_install(){
    install -d ${D}${datadir}/yang/ru/modules/oran/v12
    install -m 0555 ${S}/oran/*.yang ${D}${datadir}/yang/ru/modules/oran/v12
    install -m 0555 ${DL_DIR}/*.yang ${D}${datadir}/yang/ru/modules/oran/v12
}

FILES_${PN} += " \
    ${datadir}/yang/ru/modules/oran/v12 \
"
