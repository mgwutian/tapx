// Copyright 2009 Howard M. Lewis Ship
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.formos.tapestry.tapx.plainmessage.integration;

import com.formos.tapestry.tapx.plainmessage.services.PlainMessageModule;
import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.test.PageTester;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegrationTests extends Assert
{
    @Test
    public void sanity_check() throws Exception
    {
        PageTester pt = new PageTester("com.formos.tapestry.tapx.plainmessage.integration",
                                       "app",
                                       "/",
                                       PlainMessageModule.class);

        Document document = pt.renderPage("index");

        assertEquals(document.find("span").getChildMarkup(), "Demo of tapx-plainmessage.");
    }
}
