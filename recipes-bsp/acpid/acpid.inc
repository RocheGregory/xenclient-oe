SUMMARY = "A daemon for delivering ACPI events"
HOMEPAGE = "http://sourceforge.net/projects/acpid/"
BUGTRACKER = "http://sourceforge.net/tracker/?group_id=33140&atid=407341"
SECTION = "base"
LICENSE = "GPLv2+"

SRC_URI = "${SOURCEFORGE_MIRROR}/acpid2/acpid-${PV}.tar.xz \
           file://init \
          "

inherit autotools update-rc.d

INITSCRIPT_NAME = "acpid"
INITSCRIPT_PARAMS = "defaults"

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	sed -e 's,/usr/sbin,${sbindir},g' ${WORKDIR}/init > ${D}${sysconfdir}/init.d/acpid
	chmod 755 ${D}${sysconfdir}/init.d/acpid

	install -d ${D}${sysconfdir}/acpi
	install -d ${D}${sysconfdir}/acpi/events
}
