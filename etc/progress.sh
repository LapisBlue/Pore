#!/bin/bash
# constants
IMPL_DIR="./src/main/java/blue/lapis/pore/impl"
OVERRIDE_STR="@Override"
NOT_IMPLD_STR="throw new NotImplementedException"

# grep matches
OVERRIDES=`grep -r "$OVERRIDE_STR" $IMPL_DIR | wc -l | tr -d ' '`
NOT_IMPLD=`grep -r "$NOT_IMPLD_STR" $IMPL_DIR | wc -l | tr -d ' '`

# math to get a percentage (yay integer math :P)
IMPLD_FRACTION=$[($OVERRIDES - $NOT_IMPLD) * 10000 / $OVERRIDES]
WHOLE=$[$IMPLD_FRACTION / 100]
DECIMAL=$[$IMPLD_FRACTION % 100]
if [ $DECIMAL -lt 10 ]
then
    DECIMAL="0"$DECIMAL
fi
PERCENT_IMPLD=$WHOLE"."$DECIMAL

echo "Bukkit is roughly "$PERCENT_IMPLD"% implemented."
