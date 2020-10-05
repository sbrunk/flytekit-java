/*
 * Copyright 2020 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.flyte.api.v1;

import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;

@AutoValue
public abstract class LaunchPlan {
  public abstract String name();

  public abstract PartialWorkflowIdentifier workflowId();

  public abstract Map<String, Literal> fixedInputs();

  @Nullable
  public abstract CronSchedule cronSchedule();

  public static Builder builder() {
    return new AutoValue_LaunchPlan.Builder().fixedInputs(Collections.emptyMap());
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder name(String name);

    public abstract Builder workflowId(PartialWorkflowIdentifier workflowId);

    public abstract Builder fixedInputs(Map<String, Literal> fixedInputs);

    public abstract Builder cronSchedule(CronSchedule cronSchedule);

    public abstract LaunchPlan build();
  }
}
