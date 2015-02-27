#TODO: Remove this file after newer meta-selinux is in use.

PR = "openxt-01"

DEPENDS += "libselinux"
EXTRA_OECONF += "--with-selinux"
