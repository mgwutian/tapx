// Copyright 2009 Formos
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

package com.formos.tapestry.templating;

import java.io.IOException;

/**
 * Callback interface used with {@link com.formos.tapestry.templating.TemplateAPI#performTemplateRendererOperation(String,
 * String, String, TemplateRendererCallback)}.
 */
public interface TemplateRendererCallback
{
    /**
     * Perform the operation with the renderer.
     */
    void performOperation(TemplateRenderer renderer) throws IOException;
}