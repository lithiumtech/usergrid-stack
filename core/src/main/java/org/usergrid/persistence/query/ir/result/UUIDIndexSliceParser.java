/*******************************************************************************
 * Copyright 2012 Apigee Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.usergrid.persistence.query.ir.result;

import me.prettyprint.cassandra.serializers.UUIDSerializer;

import java.nio.ByteBuffer;
import java.util.UUID;


/**
 * Parser for reading and writing secondary index composites
 * 
 * @author tnine
 *
 */
public class UUIDIndexSliceParser implements SliceParser {

  private static final UUIDSerializer SERIALIZER = UUIDSerializer.get();

  /* (non-Javadoc)
   * @see org.usergrid.persistence.query.ir.result.SliceParser#parse(java.nio.ByteBuffer)
   */
  @Override
  public ScanColumn parse(ByteBuffer buff) {
    return new UUIDColumn(SERIALIZER.fromByteBuffer(buff.duplicate()), buff);
  }


  public static class UUIDColumn extends AbstractScanColumn{

    public UUIDColumn(UUID uuid, ByteBuffer buffer) {
      super(uuid, buffer);
    }
  }

}
