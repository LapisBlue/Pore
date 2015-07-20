#!/bin/bash
# constants
IMPL_DIR="./src/main/java/blue/lapis/pore/impl"
OVERRIDE_STR="@Override"
NOT_IMPLD_STR="throw new NotImplementedException"

# grep matches
OVERRIDES=`grep -ro "$OVERRIDE_STR" $IMPL_DIR | wc -l | cut -f1 -d ' '`
NOT_IMPLD=`grep -ro "$NOT_IMPLD_STR" $IMPL_DIR | wc -l | cut -f1 -d ' '`

# math to get a percentage (yay integer math :P)
IMPLD_FRACTION=$[($OVERRIDES - $NOT_IMPLD) * 10000 / $OVERRIDES]
WHOLE=$[$IMPLD_FRACTION / 100]
DECIMAL=$[$IMPLD_FRACTION % 100]
PERCENT_IMPLD=$WHOLE"."$DECIMAL

echo "Bukkit is roughly "$PERCENT_IMPLD"% implemented."
