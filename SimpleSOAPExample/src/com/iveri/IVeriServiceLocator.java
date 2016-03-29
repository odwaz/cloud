/**
 * IVeriServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iveri;

public class IVeriServiceLocator extends org.apache.axis.client.Service implements com.iveri.IVeriService {

    public IVeriServiceLocator() {
    }


    public IVeriServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IVeriServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for iVeriServiceSoap
    private java.lang.String iVeriServiceSoap_address = "https://portal.nedsecure.co.za/iVeriWebService/Service.asmx";

    public java.lang.String getiVeriServiceSoapAddress() {
        return iVeriServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String iVeriServiceSoapWSDDServiceName = "iVeriServiceSoap";

    public java.lang.String getiVeriServiceSoapWSDDServiceName() {
        return iVeriServiceSoapWSDDServiceName;
    }

    public void setiVeriServiceSoapWSDDServiceName(java.lang.String name) {
        iVeriServiceSoapWSDDServiceName = name;
    }

    public com.iveri.IVeriServiceSoap getiVeriServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(iVeriServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getiVeriServiceSoap(endpoint);
    }

    public com.iveri.IVeriServiceSoap getiVeriServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.iveri.IVeriServiceSoapStub _stub = new com.iveri.IVeriServiceSoapStub(portAddress, this);
            _stub.setPortName(getiVeriServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setiVeriServiceSoapEndpointAddress(java.lang.String address) {
        iVeriServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.iveri.IVeriServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.iveri.IVeriServiceSoapStub _stub = new com.iveri.IVeriServiceSoapStub(new java.net.URL(iVeriServiceSoap_address), this);
                _stub.setPortName(getiVeriServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("iVeriServiceSoap".equals(inputPortName)) {
            return getiVeriServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://iveri.com/", "iVeriService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://iveri.com/", "iVeriServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("iVeriServiceSoap".equals(portName)) {
            setiVeriServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
