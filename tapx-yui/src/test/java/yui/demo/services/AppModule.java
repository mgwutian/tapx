// Copyright 2010, 2011 Howard M. Lewis Ship
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package yui.demo.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;

import com.howardlewisship.tapx.core.CoreSymbols;
import com.howardlewisship.tapx.core.services.CoreModule;
import com.howardlewisship.tapx.yui.services.YuiModule;

@SubModule(
{ CoreModule.class, YuiModule.class })
public class AppModule
{
    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration)
    {
        configuration.add(CoreSymbols.TEST_MODE, "true");
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");

    }
}
