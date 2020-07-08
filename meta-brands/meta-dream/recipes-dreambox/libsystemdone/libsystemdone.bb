DESCRIPTION = "libsystemd precompiled for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(dreamone)$"

SRC_URI = "file://libsystemd.so.0.17.0.zip"

S = "${WORKDIR}"

do_configure() {
}

do_compile() {
}

do_install() {
	install -d ${D}/lib64
#	install -m 0755 ${S}/libsystemd.so.0 ${D}/lib64/
	install -m 0755 ${S}/libsystemd.so.0.17.0 ${D}/lib64/
	cd  ${D}/lib64
	ln -sf  libsystemd.so.0.17.0  libsystemd.so.0 
}

do_package_qa() {
}

do_populate_sysroot() {
}

FILES_${PN} += "/lib64/*"

INSANE_SKIP_${PN} = "already-stripped dev-so"
