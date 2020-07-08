SUMMARY = "OpenDreambox: WLAN support"
SECTION = "opendreambox/base"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
  wireless-tools \
  wpa-supplicant \
"

RRECOMMENDS_${PN} = " \
  ${MODULES_rtl8192} \
  kernel-module-carl9170 \
  kernel-module-r8712u \
  kernel-module-rt2800usb \
  kernel-module-rt73usb \
  kernel-module-zd1211rw \
  kernel-module-rtl88x2bu \
"
