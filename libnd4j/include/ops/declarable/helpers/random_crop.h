/*******************************************************************************
 * Copyright (c) 2015-2018 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

//
//  @author sgazeos@gmail.com
//
#ifndef __DROP_OUT_HELPERS__
#define __DROP_OUT_HELPERS__
#include <op_boilerplate.h>
#include <NDArray.h>
#include <helpers/helper_random.h>

namespace nd4j {
namespace ops {
namespace helpers {

    int randomCropFunctor(nd4j::random::RandomBuffer* rng, NDArray* input, NDArray* shape, NDArray* output, int seed);

}
}
}
#endif
