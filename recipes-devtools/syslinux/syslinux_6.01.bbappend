PR = "openxt-01"

PACKAGES =+ " \
    ${PN}-isohybrid \
    ${PN}-mboot \
    ${PN}-ldlinux \
"

FILES_${PN}-isohybrid = "${bindir}/isohybrid"
FILES_${PN}-mboot = "${datadir}/${PN}/mboot.c32"
FILES_${PN}-ldlinux = "${datadir}/${PN}/ldlinux.c32"
