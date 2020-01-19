/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.karaf.boot.jpa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface PersistentUnit {

    String name();

    String description() default "";

    TransactionType transactionType() default TransactionType.RESOURCE_LOCAL;

    Provider provider() default Provider.Default;

    String providerName() default "";

    String jtaDataSource() default "";

    String nonJtaDataSource() default "";

    // TODO: mapping-file, jar-file, class, exclude-unlisted-classes, shared-cache-mode, validation-mode

    Property[] properties() default {};


    @Target(ElementType.ANNOTATION_TYPE)
    @interface ProviderProperty {
        String value();
    }

}
