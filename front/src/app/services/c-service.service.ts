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

  saveCService(cservice: CService, image: File): Observable<CService> {
    const fd = new FormData();
    fd.append('file', image);
    fd.append('upload_preset', 'i8cspdmn');
    fd.append('public_id', cservice.name);
    this.http.post('https://api.cloudinary.com/v1_1/e1ectrof0x/image/upload', fd).subscribe();
    cservice.image = 'http://res.cloudinary.com/e1ectrof0x/image/upload/' + cservice.name;
    return this.http.post<CService>('/api/services', cservice);
  }

  deleteCService(cserviceId: string): Observable<void> {
    return this.http.delete<void>('/api/services/del/' + cserviceId);
  }

}
