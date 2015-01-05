# Copyright (C) 2014 Citrix Systems Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require kmod.inc

SRC_URI[tarball.md5sum] = "05ddd4dc163ae004359d7bebccf19c7a"
SRC_URI[tarball.sha256sum] = "ad892805df35bdf78f86171d05b781febb870d9764329ae6c8fca959b3fc4a93"

# We only want libkmod2 really...
EXTRA_OECONF = "--disable-tools --disable-manpages --disable-logging --without-bashcompletiondir"

# Let's make sure bitbake knows what we provide so it doesn't grab kmod_git
DEPENDS += "zlib"
PROVIDES += "module-init-tools-insmod-static module-init-tools-depmod module-init-tools"
RPROVIDES_${PN} += "module-init-tools-insmod-static module-init-tools-depmod module-init-tools"
RCONFLICTS_${PN} += "module-init-tools-insmod-static module-init-tools-depmod module-init-tools"
RREPLACES_${PN} += "module-init-tools-insmod-static module-init-tools-depmod module-init-tools"

# to force user to remove old module-init-tools and replace them with kmod variants
RCONFLICTS_libkmod2 += "module-init-tools-insmod-static module-init-tools-depmod module-init-tools"

