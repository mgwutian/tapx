// Copyright 2011, 2012 Howard M. Lewis Ship
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

package com.howardlewisship.tapx.internal.datefield.services;

import com.howardlewisship.tapx.datefield.services.ClientTimeZoneAnalyzer;
import com.howardlewisship.tapx.datefield.services.ClientTimeZoneData;

import java.util.TimeZone;

/**
 * The default implementation, used when information from the client can't be converted into a time zone;
 * instead uses the server's default time zone.
 */
public class SystemTimeZoneAnalyzer implements ClientTimeZoneAnalyzer
{
    public TimeZone extractTimeZone(ClientTimeZoneData data)
    {
        return TimeZone.getDefault();
    }

}