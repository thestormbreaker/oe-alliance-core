DEPENDS = "libgcc"
PROVIDES = "linux-dreambox"
PE = "1"

require recipes-linux/linux-dreambox.inc

SRC_URI = "https://dreamboxupdate.com/download/opendreambox/linux-meson64/linux-meson64-v${PV}.tar.xz"

SRC_URI[md5sum] = "a81fb5991ac515092dd5d8b5adc9a0ae"
SRC_URI[sha256sum] = "37d7713065aac1efac1b7616161924c4ca3621902794f0eab9dc1bc10df10a4a"

KERNEL_CC += "${TOOLCHAIN_OPTIONS}"
KERNEL_LD += "${TOOLCHAIN_OPTIONS}"

S = "${WORKDIR}/${BPN}-v${PV}"

CMDLINE = "${@kernel_console(d)} root=/dev/mmcblk0p7 rootwait rootfstype=ext4 no_console_suspend"

COMPATIBLE_MACHINE = "^(dreamone)$"

DEFCONFIG = "meson64"

LINUX_VERSION = "4.9"
KERNEL_DEVICETREE = "dreamone.dtb"
KERNEL_IMAGETYPES = "Image.gz"

export KCFLAGS = "-Wno-error=misleading-indentation \
                  -Wno-error=parentheses \
                  -Wno-error=shift-overflow \
                  -Wno-error=array-bounds \
                  -Wno-error=bool-compare \
                  -Wno-error=maybe-uninitialized \
                  -Wno-error=unused-variable \
                  -Wno-error=stringop-overflow \
                  -Wno-error=unused-const-variable"

do_install_prepend() {
	mv ${B}/arch/arm64/boot/dts/amlogic/dreamone.dtb ${B}/arch/arm64/boot/
}

do_compile_append() {
    if test -n "${KERNEL_DEVICETREE}"; then
    	for DTB in ${KERNEL_DEVICETREE}; do
    		if echo ${DTB} | grep -q '/dts/'; then
    			bbwarn "${DTB} contains the full path to the the dts file, but only the dtb name should be used."
    			DTB=`basename ${DTB} | sed 's,\.dts$,.dtb,g'`
    		fi
    		oe_runmake ${DTB}
    	done
    	# Create directory, this is needed for out of tree builds
    	mkdir -p ${B}/arch/arm64/boot/dts/amlogic/
    	cp ${B}/arch/arm64/boot/dts/amlogic/${KERNEL_DEVICETREE} ${B}/arch/arm64/boot/
    fi
}

KERNEL_FLASH_ARGS = "-c '${CMDLINE}'"
