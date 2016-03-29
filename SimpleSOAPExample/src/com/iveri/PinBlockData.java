/**
 * PinBlockData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iveri;

public class PinBlockData  implements java.io.Serializable {
    private int resultStatusCode;

    private java.lang.String resultDescription;

    private java.lang.String deviceSerialNumber;

    private java.lang.String deviceMake;

    private java.lang.String keySerialNumber;

    private java.lang.String pinBlock;

    private java.lang.String encryptedTrack2;

    private java.lang.String dottedPAN;

    public PinBlockData() {
    }

    public PinBlockData(
           int resultStatusCode,
           java.lang.String resultDescription,
           java.lang.String deviceSerialNumber,
           java.lang.String deviceMake,
           java.lang.String keySerialNumber,
           java.lang.String pinBlock,
           java.lang.String encryptedTrack2,
           java.lang.String dottedPAN) {
           this.resultStatusCode = resultStatusCode;
           this.resultDescription = resultDescription;
           this.deviceSerialNumber = deviceSerialNumber;
           this.deviceMake = deviceMake;
           this.keySerialNumber = keySerialNumber;
           this.pinBlock = pinBlock;
           this.encryptedTrack2 = encryptedTrack2;
           this.dottedPAN = dottedPAN;
    }


    /**
     * Gets the resultStatusCode value for this PinBlockData.
     * 
     * @return resultStatusCode
     */
    public int getResultStatusCode() {
        return resultStatusCode;
    }


    /**
     * Sets the resultStatusCode value for this PinBlockData.
     * 
     * @param resultStatusCode
     */
    public void setResultStatusCode(int resultStatusCode) {
        this.resultStatusCode = resultStatusCode;
    }


    /**
     * Gets the resultDescription value for this PinBlockData.
     * 
     * @return resultDescription
     */
    public java.lang.String getResultDescription() {
        return resultDescription;
    }


    /**
     * Sets the resultDescription value for this PinBlockData.
     * 
     * @param resultDescription
     */
    public void setResultDescription(java.lang.String resultDescription) {
        this.resultDescription = resultDescription;
    }


    /**
     * Gets the deviceSerialNumber value for this PinBlockData.
     * 
     * @return deviceSerialNumber
     */
    public java.lang.String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }


    /**
     * Sets the deviceSerialNumber value for this PinBlockData.
     * 
     * @param deviceSerialNumber
     */
    public void setDeviceSerialNumber(java.lang.String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }


    /**
     * Gets the deviceMake value for this PinBlockData.
     * 
     * @return deviceMake
     */
    public java.lang.String getDeviceMake() {
        return deviceMake;
    }


    /**
     * Sets the deviceMake value for this PinBlockData.
     * 
     * @param deviceMake
     */
    public void setDeviceMake(java.lang.String deviceMake) {
        this.deviceMake = deviceMake;
    }


    /**
     * Gets the keySerialNumber value for this PinBlockData.
     * 
     * @return keySerialNumber
     */
    public java.lang.String getKeySerialNumber() {
        return keySerialNumber;
    }


    /**
     * Sets the keySerialNumber value for this PinBlockData.
     * 
     * @param keySerialNumber
     */
    public void setKeySerialNumber(java.lang.String keySerialNumber) {
        this.keySerialNumber = keySerialNumber;
    }


    /**
     * Gets the pinBlock value for this PinBlockData.
     * 
     * @return pinBlock
     */
    public java.lang.String getPinBlock() {
        return pinBlock;
    }


    /**
     * Sets the pinBlock value for this PinBlockData.
     * 
     * @param pinBlock
     */
    public void setPinBlock(java.lang.String pinBlock) {
        this.pinBlock = pinBlock;
    }


    /**
     * Gets the encryptedTrack2 value for this PinBlockData.
     * 
     * @return encryptedTrack2
     */
    public java.lang.String getEncryptedTrack2() {
        return encryptedTrack2;
    }


    /**
     * Sets the encryptedTrack2 value for this PinBlockData.
     * 
     * @param encryptedTrack2
     */
    public void setEncryptedTrack2(java.lang.String encryptedTrack2) {
        this.encryptedTrack2 = encryptedTrack2;
    }


    /**
     * Gets the dottedPAN value for this PinBlockData.
     * 
     * @return dottedPAN
     */
    public java.lang.String getDottedPAN() {
        return dottedPAN;
    }


    /**
     * Sets the dottedPAN value for this PinBlockData.
     * 
     * @param dottedPAN
     */
    public void setDottedPAN(java.lang.String dottedPAN) {
        this.dottedPAN = dottedPAN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PinBlockData)) return false;
        PinBlockData other = (PinBlockData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.resultStatusCode == other.getResultStatusCode() &&
            ((this.resultDescription==null && other.getResultDescription()==null) || 
             (this.resultDescription!=null &&
              this.resultDescription.equals(other.getResultDescription()))) &&
            ((this.deviceSerialNumber==null && other.getDeviceSerialNumber()==null) || 
             (this.deviceSerialNumber!=null &&
              this.deviceSerialNumber.equals(other.getDeviceSerialNumber()))) &&
            ((this.deviceMake==null && other.getDeviceMake()==null) || 
             (this.deviceMake!=null &&
              this.deviceMake.equals(other.getDeviceMake()))) &&
            ((this.keySerialNumber==null && other.getKeySerialNumber()==null) || 
             (this.keySerialNumber!=null &&
              this.keySerialNumber.equals(other.getKeySerialNumber()))) &&
            ((this.pinBlock==null && other.getPinBlock()==null) || 
             (this.pinBlock!=null &&
              this.pinBlock.equals(other.getPinBlock()))) &&
            ((this.encryptedTrack2==null && other.getEncryptedTrack2()==null) || 
             (this.encryptedTrack2!=null &&
              this.encryptedTrack2.equals(other.getEncryptedTrack2()))) &&
            ((this.dottedPAN==null && other.getDottedPAN()==null) || 
             (this.dottedPAN!=null &&
              this.dottedPAN.equals(other.getDottedPAN())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getResultStatusCode();
        if (getResultDescription() != null) {
            _hashCode += getResultDescription().hashCode();
        }
        if (getDeviceSerialNumber() != null) {
            _hashCode += getDeviceSerialNumber().hashCode();
        }
        if (getDeviceMake() != null) {
            _hashCode += getDeviceMake().hashCode();
        }
        if (getKeySerialNumber() != null) {
            _hashCode += getKeySerialNumber().hashCode();
        }
        if (getPinBlock() != null) {
            _hashCode += getPinBlock().hashCode();
        }
        if (getEncryptedTrack2() != null) {
            _hashCode += getEncryptedTrack2().hashCode();
        }
        if (getDottedPAN() != null) {
            _hashCode += getDottedPAN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PinBlockData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://iveri.com/", "PinBlockData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultStatusCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://iveri.com/", "ResultStatusCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("http://iveri.com/", "ResultDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceSerialNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://iveri.com/", "DeviceSerialNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceMake");
        elemField.setXmlName(new javax.xml.namespace.QName("http://iveri.com/", "DeviceMake"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keySerialNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://iveri.com/", "KeySerialNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pinBlock");
        elemField.setXmlName(new javax.xml.namespace.QName("http://iveri.com/", "PinBlock"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedTrack2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://iveri.com/", "EncryptedTrack2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dottedPAN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://iveri.com/", "DottedPAN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
