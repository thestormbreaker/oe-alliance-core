DESCRIPTION = "missing precompiled for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "^(dreamone)$"

SRC_URI = "file://misc.zip"

S = "${WORKDIR}"

do_configure() {
}

do_compile() {
}

do_install() {
	install -d ${D}/boot
	install -d ${D}/etc/u-boot.scr.d
	install -d ${D}/usr/bin
	install -d ${D}/usr/sbin
	install -m 0644 ${S}/boot/autoexec.img ${D}/boot
#	install -m 0644 ${S}/etc/meson_egl.conf ${D}/etc
#	install -m 0644 ${S}/etc/u-boot.scr.d/* ${D}/etc/u-boot.scr.d
	install -m 0755 ${S}/usr/bin/* ${D}/usr/bin
	install -m 0755 ${S}/usr/sbin/* ${D}/usr/sbin
	
#	install -m 0755 ${S}/libsystemd.so.0 ${D}/lib/
##	install -m 0755 ${S}/libsystemd.so.0.17.0 ${D}/lib/
#	cd  ${D}/lib
#	ln -sf libsystemd.so.0 ${D}$/lib/libsystemd.so.0.17.0
}

do_package_qa() {
}

do_populate_sysroot() {
}

FILES_${PN} += "/etc/*  /boot/* /etc/*  /usr/*"

INSANE_SKIP_${PN} = "already-stripped dev-so"
