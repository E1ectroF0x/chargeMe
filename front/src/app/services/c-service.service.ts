import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CService} from '../modules/cservice/models/c-service';
import {Sub} from '../modules/cservice/models/sub';


@Injectable()
export class CServiceService {

  constructor(private http: HttpClient) {
  }

  getCServices(): Observable<CService[]> {
    return this.http.get<CService[]>('/api/services/all');
  }

  saveCService(cservice: CService, image: File): Observable<CService> {
    const fd = new FormData();
    fd.append('file', image);
    fd.append('upload_preset', 'i8cspdmn');
    let name: string;
    if (image) {
      name = cservice.name;
    } else {
      name = 'warning';
    }
    fd.append('public_id', name);
    this.http.post('https://api.cloudinary.com/v1_1/e1ectrof0x/image/upload', fd).subscribe();
    cservice.image = 'http://res.cloudinary.com/e1ectrof0x/image/upload/' + name;
    return this.http.post<CService>('/api/services', cservice);
  }

  deleteCService(cserviceId: string): Observable<void> {
    return this.http.delete<void>('/api/services/del/' + cserviceId);
  }

  getSubscribers(cserviceId: string): Observable<Sub> {
    return this.http.get<Sub>('/api/services/sub/' + cserviceId);
  }

}
