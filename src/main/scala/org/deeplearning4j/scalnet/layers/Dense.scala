/*
 *
 *  * Copyright 2016 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package org.deeplearning4j.scalnet.layers

import org.deeplearning4j.nn.conf.layers.{DenseLayer, OutputLayer}
import org.deeplearning4j.nn.weights.WeightInit
import org.deeplearning4j.scalnet.regularizers.{NoRegularizer, WeightRegularizer}

/**
  * Fully connected neural net layer.
  *
  * @author David Kale
  */
class Dense(
    nOut: Int,
    nIn: Int = 0,
    val weightInit: WeightInit = WeightInit.VI,
    val activation: String = "identity",
    val regularizer: WeightRegularizer = NoRegularizer(),
    val dropOut: Double = 0.0,
    override val name: String = null)
  extends Node with Layer with Output {

  _outputShape = List(nOut)
  inputShape = List(nIn)

  override def compile: org.deeplearning4j.nn.conf.layers.Layer = {
    if (isOutput){
      new OutputLayer.Builder(_lossFunction)
        .nIn(inputShape.last)
        .nOut(outputShape.last)
        .weightInit(weightInit)
        .activation(activation)
        .l1(regularizer.l1)
        .l2(regularizer.l2)
        .dropOut(dropOut)
        .name(name)
        .build()
    }
    else {
      new DenseLayer.Builder()
        .nIn(inputShape.last)
        .nOut(outputShape.last)
        .weightInit(weightInit)
        .activation(activation)
        .l1(regularizer.l1)
        .l2(regularizer.l2)
        .dropOut(dropOut)
        .name(name)
        .build()
    }
  }
}
