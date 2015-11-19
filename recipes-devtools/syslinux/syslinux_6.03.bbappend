PR .= ".1"

PACKAGES =+ " \
    ${PN}-isohybrid \
    ${PN}-mboot \
    ${PN}-ldlinux \
    ${PN}-libcom32 \
"

FILES_${PN}-isohybrid = "${bindir}/isohybrid"
FILES_${PN}-mboot = "${datadir}/${PN}/mboot.c32"
FILES_${PN}-ldlinux = "${datadir}/${PN}/ldlinux.c32"
FILES_${PN}-libcom32 = "${datadir}/${PN}/libcom32.c32"