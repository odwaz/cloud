/**
 * IVeriServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iveri;

public interface IVeriServiceSoap extends java.rmi.Remote {
    public java.lang.String execute(boolean validateRequest, java.lang.String protocol, java.lang.String protocolVersion, java.lang.String request) throws java.rmi.RemoteException;
    public java.lang.String generateCertificateID(java.lang.String billingDetailsID) throws java.rmi.RemoteException;
    public java.lang.String renewCertificateID(java.lang.String billingDetailsID, java.lang.String certificateID) throws java.rmi.RemoteException;
    public java.lang.String sumitCertificateRequest(java.lang.String certificateID, java.lang.String certificateSigningRequest) throws java.rmi.RemoteException;
    public java.lang.String getCertificate(java.lang.String certificateID) throws java.rmi.RemoteException;
    public com.iveri.PinBlockData getPinBlock(java.lang.String mode, java.lang.String pan, int expiryMonth, int expiryYear, java.lang.String pin) throws java.rmi.RemoteException;
    public java.lang.String uploadFile(java.lang.String fileServiceCommand, byte[] fileData) throws java.rmi.RemoteException;
    public java.lang.String isDataAvailable(java.lang.String fileServiceCommand) throws java.rmi.RemoteException;
    public byte[] downloadFile(java.lang.String fileServiceCommand) throws java.rmi.RemoteException;
}
