/*
 * Copyright 2007 the original author or authors.
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

package org.gradle.api.tasks.testing

import org.gradle.api.tasks.compile.AbstractOptions

/**
 * @author Hans Dockter
 */
class JunitOptions extends AbstractOptions {
    boolean fork = true
    boolean filterTrace = true
    boolean showOutput = false
    boolean outputToFormatters = true
    boolean reloading = true

    String tempDir = null
    String printSummary = 'true'

    FormatterOptions formatterOptions = new FormatterOptions()
    JunitForkOptions forkOptions = new JunitForkOptions()

    Map systemProperties = [:]
    Map environment = [:]

    List excludedFieldsFromOptionMap() {
        ['systemProperties', 'environment', 'formatterOptions', 'forkOptions']
    }

    Map fieldName2AntMap() {
        [
                filterTrace: 'filtertrace',
                outputToFormatters: 'outputtoformatters',
                showOutput: 'showoutput',
                tempDir: 'tempdir',
                printSummary: 'printsummary'
        ]
    }

    Map optionMap() {
        super.optionMap() + forkOptions.optionMap()
    }

    JunitOptions fork(Map forkArgs) {
        fork = true
        forkOptions.define(forkArgs)
        this
    }
}
