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
import joptsimple.OptionSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.JOptCommandLinePropertySource;
import org.springframework.core.env.PropertySource;

@SpringBootApplication
public class SpringJoptCliExampleApplication {

    public static void main(String[] args) {
        JOptCommandLinePropertySource soclps;

        OptionParser op = new OptionParser();
        op.accepts("option1");
        op.accepts("option2").withRequiredArg();
        OptionSet os = op.parse(args);

        PropertySource<?> ps = new JOptCommandLinePropertySource(os);

        SpringApplication.run(SpringJoptCliExampleApplication.class, args);
    }
}
