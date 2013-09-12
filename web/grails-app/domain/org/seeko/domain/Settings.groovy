package org.seeko.domain

class Settings {

    String key;
    String value;

    static constraints = {
        key(blank: false, maxSize: 255)
        value(blank: true, maxSize: 255)
    }
}
