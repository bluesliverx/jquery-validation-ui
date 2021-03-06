/* Copyright 2010 the original author or authors.
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
package org.grails.jquery.validation.ui

import grails.test.*


/**
*
* @author <a href='mailto:limcheekin@vobject.com'>Lim Chee Kin</a>
*
* @since 1.1
*/
class PhoneUSConstraintTests extends GroovyTestCase {

    void testPhoneValidationNotCalledIfFalsePassedAsParam() {
        def v = new PhoneUSConstraint()
        v.metaClass.getParams = {-> false }
        
        assert v.validate("555-555-1212")
    }
    
    void testValidUsPhones() {
        def v = new PhoneUSConstraint()
        v.metaClass.getParams = {-> true }
        
        assert v.validate("555-555-1212")
        assert v.validate("1-800-555-1212")
    }

    void testInvalidUsPhones() {
        def v = new PhoneUSConstraint()
        v.metaClass.getParams = {-> true }
        
        assert ! v.validate("555-555-12123")
        assert ! v.validate("1-800-5553-1212")
        assert ! v.validate("1-800-5553-xxxx")
        assert ! v.validate("         ")
        assert ! v.validate("")
        assert ! v.validate(null)
    }
}
