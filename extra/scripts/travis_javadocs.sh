#!/bin/bash
if [ "$TRAVIS_JDK_VERSION" = "oraclejdk8" ]; then
    git clone https://${GH_TOKEN}@github.com/LapisBlue/Javadocs .jd
    mvn javadoc:javadoc && {
        cd .jd/
        git config user.name "Lapislazuli"
        git config user.email "lapislazuli@lapis.blue"
        git rm -r pore
        cp -r ../target/site/apidocs/ pore
        git add -A
        git commit -m "Update to $TRAVIS_REPO_SLUG@$TRAVIS_COMMIT (Build $TRAVIS_BUILD_NUMBER)"
        git push origin gh-pages
    }
fi
