export class ChargingDataViewModel {
  cserviceId: string;
  customerId: string;
  walletId: string;

  constructor(cserviceId: string, customerId: string, walletId: string) {
    this.cserviceId = cserviceId;
    this.customerId = customerId;
    this.walletId = walletId;
  }
}
