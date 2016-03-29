package com.iveri;

public class IVeriServiceSoapProxy implements com.iveri.IVeriServiceSoap {
  private String _endpoint = null;
  private com.iveri.IVeriServiceSoap iVeriServiceSoap = null;
  
  public IVeriServiceSoapProxy() {
    _initIVeriServiceSoapProxy();
  }
  
  public IVeriServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initIVeriServiceSoapProxy();
  }
  
  private void _initIVeriServiceSoapProxy() {
    try {
      iVeriServiceSoap = (new com.iveri.IVeriServiceLocator()).getiVeriServiceSoap();
      if (iVeriServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iVeriServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iVeriServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iVeriServiceSoap != null)
      ((javax.xml.rpc.Stub)iVeriServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.iveri.IVeriServiceSoap getIVeriServiceSoap() {
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap;
  }
  
  public java.lang.String execute(boolean validateRequest, java.lang.String protocol, java.lang.String protocolVersion, java.lang.String request) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.execute(validateRequest, protocol, protocolVersion, request);
  }
  
  public java.lang.String generateCertificateID(java.lang.String billingDetailsID) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.generateCertificateID(billingDetailsID);
  }
  
  public java.lang.String renewCertificateID(java.lang.String billingDetailsID, java.lang.String certificateID) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.renewCertificateID(billingDetailsID, certificateID);
  }
  
  public java.lang.String sumitCertificateRequest(java.lang.String certificateID, java.lang.String certificateSigningRequest) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.sumitCertificateRequest(certificateID, certificateSigningRequest);
  }
  
  public java.lang.String getCertificate(java.lang.String certificateID) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.getCertificate(certificateID);
  }
  
  public com.iveri.PinBlockData getPinBlock(java.lang.String mode, java.lang.String pan, int expiryMonth, int expiryYear, java.lang.String pin) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.getPinBlock(mode, pan, expiryMonth, expiryYear, pin);
  }
  
  public java.lang.String uploadFile(java.lang.String fileServiceCommand, byte[] fileData) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.uploadFile(fileServiceCommand, fileData);
  }
  
  public java.lang.String isDataAvailable(java.lang.String fileServiceCommand) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.isDataAvailable(fileServiceCommand);
  }
  
  public byte[] downloadFile(java.lang.String fileServiceCommand) throws java.rmi.RemoteException{
    if (iVeriServiceSoap == null)
      _initIVeriServiceSoapProxy();
    return iVeriServiceSoap.downloadFile(fileServiceCommand);
  }
  
  
}