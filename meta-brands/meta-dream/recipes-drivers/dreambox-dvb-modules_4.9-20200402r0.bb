SRC_URI[dreamone.md5sum] = "ccee34a5defb6285b43229af239b97b6"
SRC_URI[dreamone.sha256sum] = "d292564df1c53d00afec5c65be01134e286c92ae34d070cebbfcf586928ea2c6"

require dreambox-dvb-modules-meson.inc

RREPLACES_${PN} += "dreamframeinject"
RPROVIDES_${PN} += "dreamframeinject"
RCONFLICTS_${PN} += "dreamframeinject"

SRC_URI += "file://LICENSE-CLOSE"

do_license() {
	mv ${WORKDIR}/LICENSE-CLOSE ${B}/LICENSE-CLOSE
}

addtask do_license before do_populate_lic after do_unpack
