@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type=LocalDate.class, value = LocalDateAdapter.class)
})
package com.actimem.blog.jaxb.adapters;

import serialization.LocalDateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDate;