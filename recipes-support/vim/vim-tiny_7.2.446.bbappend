PR = "openxt-01"

inherit autotools-brokensep update-alternatives

DEPENDS += "libselinux"
EXTRA_OECONF += "--enable-selinux --disable-acl"
