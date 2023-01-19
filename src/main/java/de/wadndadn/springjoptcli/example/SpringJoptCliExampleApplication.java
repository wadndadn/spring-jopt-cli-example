/*
 * Copyright 2023 wad'n dad'n
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.wadndadn.springjoptcli.example;

import joptsimple.OptionParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.JOptCommandLinePropertySource;
import org.springframework.core.env.PropertySource;

@Slf4j
@SpringBootApplication
public class SpringJoptCliExampleApplication {

    public static void main(final String[] args) {
        final PropertySource<?> propertySource = createPropertySource(args);

        if (log.isInfoEnabled()) {
            log.info("Name: '{}'", propertySource.getName());
            log.info("Source: '{}'", propertySource.getSource());
        }

        SpringApplication.run(SpringJoptCliExampleApplication.class, args);
    }

    private static PropertySource<?> createPropertySource(final String[] args) {
        if (log.isInfoEnabled()) {
            log.info("Create property source for command line arguments: '{}'", (Object) args);
        }

        final var optionParser = new OptionParser();
        optionParser.accepts("o1").withRequiredArg();
        optionParser.accepts("o2");

        final var optionSet = optionParser.parse(args);

        final PropertySource<?> propertySource = new JOptCommandLinePropertySource(optionSet);

        if (log.isInfoEnabled()) {
            log.info("Created property source: '{}'", propertySource);
        }

        return propertySource;
    }
}
