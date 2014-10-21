/*
 * Copyright 2012 the original author or authors.
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
package com.sri.shareurl.addurl.neo4j.entities;

import org.springframework.data.neo4j.annotation.GraphId;

public abstract class AbstractEntity {

	@GraphId
	private Long id;

	transient private Integer hash;
	
	public Long getId() {
		return id;
	}

	
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

        if (id == null || obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        return id.equals(((AbstractEntity) obj).id);

    }

	public int hash2Code() {
		return id == null ? System.identityHashCode(this) : id.hashCode();
	}

	public int hashCode() {
		if (hash == null)
			hash = id == null ? System.identityHashCode(this) : id.hashCode();

		return hash.hashCode();
	}
}
