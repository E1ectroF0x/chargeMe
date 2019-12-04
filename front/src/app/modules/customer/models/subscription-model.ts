import {CService} from '../../cservice/models/c-service';

export class SubscriptionModel {
  id: string;
  cservice: CService;
  blocked: boolean;
}
