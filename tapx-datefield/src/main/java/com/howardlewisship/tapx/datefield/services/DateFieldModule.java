// Copyright 2009, 2010, 2012 Howard M. Lewis Ship
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

package com.howardlewisship.tapx.datefield.services;

import com.howardlewisship.tapx.datefield.DateFieldSymbols;
import com.howardlewisship.tapx.internal.datefield.services.BestGuessTimeZoneAnalyzer;
import com.howardlewisship.tapx.internal.datefield.services.ClientTimeZoneTrackerImpl;
import com.howardlewisship.tapx.internal.datefield.services.DateFieldFormatConverterImpl;
import com.howardlewisship.tapx.internal.datefield.services.SystemTimeZoneAnalyzer;
import org.apache.tapestry5.ioc.*;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Marker;
import org.apache.tapestry5.ioc.annotations.Primary;
import org.apache.tapestry5.ioc.annotations.Value;
import org.apache.tapestry5.ioc.services.ChainBuilder;
import org.apache.tapestry5.services.BeanBlockContribution;
import org.apache.tapestry5.services.EditBlockContribution;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.javascript.JavaScriptStack;

import java.util.List;

public class DateFieldModule
{
    public static void bind(ServiceBinder binder)
    {
        binder.bind(DateFieldFormatConverter.class, DateFieldFormatConverterImpl.class);
        binder.bind(ClientTimeZoneTracker.class, ClientTimeZoneTrackerImpl.class);
    }

    public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration)
    {
        configuration.add(DateFieldSymbols.JSCALENDAR_PATH,
                "classpath:/com/howardlewisship/tapx/datefield/jscalendar-1.0");
        configuration.add(DateFieldSymbols.SKIN, "aqua");
        configuration.add(DateFieldSymbols.THEME, "");
    }

    public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration)
    {
        configuration.add(new LibraryMapping("tapx", "com.howardlewisship.tapx.datefield"));
    }

    public static void contributeBeanBlockOverrideSource(
            Configuration<BeanBlockContribution> configuration)
    {
        configuration.add(new EditBlockContribution("date", "tapx/DateFieldEditBlocks", "date"));
    }

    public static void contributeJavaScriptStackSource(
            MappedConfiguration<String, JavaScriptStack> configuration)
    {
        configuration.addInstance("tapx-datefield", DateFieldStack.class);
    }

    public static void contributeComponentMessagesSource(
            OrderedConfiguration<Resource> configuration,
            @Value("com/howardlewisship/tapx/datefield/tapx-datefield.properties")
            Resource catalog)
    {
        configuration.add("TapxDateField", catalog, "before:AppCatalog");
    }

    @Marker(Primary.class)
    public static ClientTimeZoneAnalyzer build(List<ClientTimeZoneAnalyzer> configuration,
                                               ChainBuilder builder)
    {
        return builder.build(ClientTimeZoneAnalyzer.class, configuration);
    }

    /**
     * Provides the default set of {@link ClientTimeZoneAnalyzer}s:
     * <dl>
     * <dt>BestGuess</dt>
     * <dd>Finds <em>some</em> TimeZone that has the correct offset (remember that multiple
     * TimeZones often share an offset)
     * <dt>System</dt>
     * <dd>Fallback, ordered last, the returns the System's default time zone
     * </dl>
     */
    @Contribute(ClientTimeZoneAnalyzer.class)
    @Primary
    public static void setupDefaultAnalyzers(
            OrderedConfiguration<ClientTimeZoneAnalyzer> configuration)
    {
        configuration.add("BestGuess", new BestGuessTimeZoneAnalyzer());
        configuration.add("System", new SystemTimeZoneAnalyzer(), "after:*");
    }
}
