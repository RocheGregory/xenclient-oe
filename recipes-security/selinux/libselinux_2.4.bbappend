#
# Ensure that we're using our own version of coreutils, rather than
# the host's coreutils, as we'll need to use ln --relative.
#
DEPENDS += "coreutils-native"
