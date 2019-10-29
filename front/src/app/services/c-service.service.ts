import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CService} from '../modules/cservice/models/c-service';


@Injectable()
export class CServiceService {

  constructor(private http: HttpClient) {
  }

  getCServices(): Observable<CService[]> {
    return this.http.get<CService[]>('/api/services/all');
  }

  saveCService(cservice: CService): Observable<CService> {
    return this.http.post<CService>('/api/services', cservice);
  }

  deleteCService(cserviceId: string): Observable<void> {
    return this.http.delete<void>('/api/services/del/' + cserviceId);
  }

}
