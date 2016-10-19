/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.emc.pravega.controller.store.task;

import com.emc.pravega.controller.store.stream.StoreConfiguration;
import org.apache.commons.lang.NotImplementedException;

/**
 * Task store factory
 */
public class TaskStoreFactory {
    public enum StoreType {
        InMemory,
        Zookeeper,
        ECS,
        S3,
        HDFS
    }

    public static TaskMetadataStore createStore(StoreType type, StoreConfiguration config, String hostId) {
        switch (type) {
            case Zookeeper:
                return new ZKTaskMetadataStore(config, hostId);
            case InMemory:
            case ECS:
            case S3:
            case HDFS:
            default:
                throw new NotImplementedException();
        }
    }
}
