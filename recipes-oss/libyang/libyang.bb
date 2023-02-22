SECTION = "libs"

DEPENDS = "pcre"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD;md5=3775480a712fc46a69647678acb234cb"

SRC_URI = "git://git.codelinaro.org/clo/le/libyang/;branch=caf3/libyang1"

SRCREV = "127c1a97784f0dacc44b93f7f19d57ffcd5e8de4"

S = "${WORKDIR}/git"

inherit cmake

do_install_append(){
	install -d ${D}/usr/share/cmake/Modules/
	install -m 0644 ${S}/FindLibYANG.cmake ${D}/usr/share/cmake/Modules/FindLibYANG.cmake
}

EXTRA_OECMAKE += " \
	-DCMAKE_BUILD_TYPE=RELEASE \
	-DGEN_LANGUAGE_BINDINGS=TRUE \
	-DGEN_PYTHON_BINDINGS=FALSE \
"
FILES_${PN} += " \
	/usr/share/cmake/Modules/FindLibYANG.cmake \
	${libdir}/libyang1/extensions/yangdata.so \
	${libdir}/libyang1/extensions/nacm.so \
	${libdir}/libyang1/extensions/metadata.so \
	${libdir}/libyang1/user_types/user_yang_types.so \
	${libdir}/libyang1/user_types/user_inet_types.so \
	"
