/*
 * Copyright 2006-2013 Alessandro Cocco.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jcodecollector.common.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author andbin
 */
@Entity
public class Tag implements Comparable<Tag>, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String name;

    private String category;

    private boolean selected;

    protected Tag() {
    }

    public Tag(String category, String name, boolean selected) {
        this.category = category;
        this.name = name;
        this.selected = selected;
    }

    public Tag(String category, String name) {
        this(category, name, false);
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public int compareTo(Tag o) {
        int categories = category.compareToIgnoreCase(o.category);
        int names = name.compareToIgnoreCase(o.name);

        if (categories != 0) {
            return categories;
        } else if (names != 0) {
            return names;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tag other = (Tag) obj;
        if (this.category != other.category
                && (this.category == null || !this.category.equals(other.category))) {
            return false;
        }
        if (this.name != other.name
                && (this.name == null || !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.category != null ? this.category.hashCode() : 0);
        return hash;
    }
}
