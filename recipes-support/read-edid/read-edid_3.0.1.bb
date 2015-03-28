DESCRIPTION = "read-edid elucidates various very useful informations from a conforming PnP monitor"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=36c7536ba19811d66ab53d9a19cbde7e"

SRC_URI = "http://polypux.org/projects/read-edid/read-edid-${PV}.tar.gz "

SRC_URI[md5sum] = "81f6a57162127ab9e969da53bc290e63"
SRC_URI[sha256sum] = "17430e66dc03812b6f1ac532acb65c8e3837dd0e90b6b45e1c4ea324d60a8027"

inherit pkgconfig cmake

# Don't build the classic VBE interface at all
EXTRA_OECMAKE = " -DCLASSICBUILD=OFF "

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/parse-edid/parse-edid ${D}${bindir}
    install -m 0755 ${B}/get-edid/get-edid ${D}${bindir}
}

