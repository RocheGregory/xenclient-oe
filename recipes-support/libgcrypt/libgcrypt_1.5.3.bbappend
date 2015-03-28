PR = "openxt-01"

# disable capabilities as gcrypt tries to drop privileges and this causes issues with cryptsetup:
# http://code.google.com/p/cryptsetup/issues/detail?id=47
EXTRA_OECONF += "--with-capabilities=no"
DEPENDS = "libgpg-error"
