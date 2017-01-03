/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SAT.utils;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import eu.hansolo.medusa.Section;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author tonovarela
 */
public class GaugeControl extends VBox {

    Gauge _gauge;
      private final StringProperty label;     
      private final DoubleProperty value;

    public StringProperty LabelProperty() {
        return label;
    } 
    public DoubleProperty ValueProperty() {
        return value;
    }
            
    public GaugeControl() {
        label= new SimpleStringProperty();
        value= new SimpleDoubleProperty();        
        
        GaugeBuilder builder;
        builder = GaugeBuilder.create()
                .skinType(Gauge.SkinType.FLAT);
        _gauge = builder
                .animated(true)
                .sectionsVisible(true)
                .checkSectionsForValue(true)
                .highlightSections(true)
                .sections(new Section(0, 25, Color.rgb(229, 115, 115)),
                        new Section(25, 50, Color.rgb(255, 183, 77)),
                        new Section(50, 75, Color.rgb(129, 199, 132)),
                        new Section(75, 100, Color.rgb(77, 208, 225)))
                .build();
        _gauge.setMaxValue(100);
        _gauge.setValueColor(Color.rgb(39, 44, 50));
        
        _gauge.setBarColor(Color.rgb(129, 199, 132));
        _gauge.setBarBackgroundColor(Color.rgb(39, 44, 50));

        _gauge.setBackgroundPaint(Color.WHITE);
        _gauge.valueProperty().bind(value);
        _gauge.LabelProperty().bind(label);      
        super.getChildren().add(_gauge);
    }
     

    
    

        
    
    

   

}
