export class ChargingDataViewModel {
  cserviceId: string;
  customerId: string;
  walletId: string;
  isBlocked: boolean;

  constructor(cserviceId: string, customerId: string, walletId: string, isBlocked: boolean) {
    this.cserviceId = cserviceId;
    this.customerId = customerId;
    this.walletId = walletId;
    this.isBlocked = isBlocked;
  }
}
